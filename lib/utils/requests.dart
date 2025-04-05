import 'package:dio/dio.dart';
import 'package:fluttertoast/fluttertoast.dart';
import 'logger.dart';


class HttpMethod {
  static const String post = "POST";
  static const String get = "GET";
  static const String put = "PUT";
  static const String delete = "DELETE";
  static const String options = "OPTIONS";
  static const String connect = "CONNECT";
  static const String trace = "TRACE";
}

class ResponseModel<T> {
  T? data;
  int? code;
  String? message;
  bool? success;

  ResponseModel.fromJson(dynamic json) {
    data = json['data'];
    code = json['code'];
    message = json['message'];
    success = json['success'];
  }

}

class PrintLogInterceptor extends InterceptorsWrapper {

  @override
  void onRequest(RequestOptions options, RequestInterceptorHandler handler) {
    Logger.println("\nonRequest----------->");
    options.headers.forEach((key, value) {
      Logger.println("headers: $key=$value");
    });
    Logger.println("path: ${options.uri}");
    Logger.println("method: ${options.method}");
    Logger.println("data: ${options.data}");
    Logger.println("queryParams: ${options.queryParameters.toString()}");
    Logger.println("<-----------onRequest\n");
    super.onRequest(options, handler);
  }

}

class ResponseInterceptor extends Interceptor {

  @override
  void onResponse(Response response, ResponseInterceptorHandler handler) {
    if (response.statusCode == 200) {
      var resp = ResponseModel.fromJson(response.data);
      if (resp.code == 200) {
        handler.next(Response(requestOptions: response.requestOptions, data: resp.data));
      } else {
        handler.next(Response(requestOptions: response.requestOptions, data: true));
      }
    } else {
      super.onResponse(response, handler);
    }
  }

}

class ErrorHandlerInterceptor extends Interceptor {

  @override
  void onError(DioException err, ErrorInterceptorHandler handler) {
    String errorMessage = "请检查网络";
    if (err.type == DioExceptionType.connectionTimeout
        || err.type == DioExceptionType.sendTimeout) {
      errorMessage = "连接超时，请检查网络连接";
    } else if (err.type == DioExceptionType.receiveTimeout) {
      errorMessage = "服务器响应超时，请稍后重试";
    } else if (err.response?.statusCode == 404) {
      errorMessage = "请求的资源不存在";
    } else if (err.type == DioExceptionType.unknown) {
      errorMessage = "未知错误，请重试";
    }
    Fluttertoast.showToast(msg: errorMessage);
    return handler.next(err);
  }

}


class Requests {
  static Requests? _instance;
  Requests._();

  final Dio _dio = Dio();
  final _defaultTimeout = const Duration(seconds: 30);

  static Requests instance() {
    return _instance ??= Requests._();
  }

  static void initialize() {
    Requests.instance().initHttpClient();
  }

  void initHttpClient({
    String? baseUrl,
    String? httpMethod = HttpMethod.get,
    Duration? connectTimeout,
    Duration? receiveTimeout,
    Duration? sendTimeout,
    ResponseType? responseType = ResponseType.json,
    String? contentType,
  }) {
    _dio.options = BaseOptions(
        method: httpMethod,
        baseUrl: baseUrl ?? '',
        connectTimeout: connectTimeout ?? _defaultTimeout,
        receiveTimeout: receiveTimeout ?? _defaultTimeout,
        sendTimeout: sendTimeout ?? _defaultTimeout,
        responseType: responseType,
        contentType: contentType
    );
    _dio.interceptors.add(PrintLogInterceptor());
    _dio.interceptors.add(ErrorHandlerInterceptor());
  }

  Future<Response> get({
    required String path,
    Object? data,
    Map<String, dynamic>? queryParams,
    Options? options,
    CancelToken? cancelToken,
  }) async {
    return _dio.get(
        path,
        queryParameters: queryParams,
        data: data,
        cancelToken: cancelToken,
        options: options ?? Options(
            method: HttpMethod.get,
            receiveTimeout: _defaultTimeout,
            sendTimeout: _defaultTimeout
        )
    );
  }

  Future<Response> post({
    required String path,
    Object? data,
    Map<String, dynamic>? queryParams,
    Options? options,
    CancelToken? cancelToken,
  }) async {
    return _dio.post(
        path,
        queryParameters: queryParams,
        data: data,
        cancelToken: cancelToken,
        options: options ?? Options(
            method: HttpMethod.post,
            receiveTimeout: _defaultTimeout,
            sendTimeout: _defaultTimeout
        )
    );
  }

}