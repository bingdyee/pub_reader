import 'package:shared_preferences/shared_preferences.dart';


/// SharedPreferences 管理工具类（单例模式）
class SharedStorageManager {

  SharedStorageManager._internal();

  static final SharedStorageManager _instance = SharedStorageManager._internal();

  static SharedStorageManager get instance => _instance;

  late final SharedPreferences _prefs;

  // 初始化 SharedPreferences
  Future<void> _init() async {
    _prefs = await SharedPreferences.getInstance();
  }

  // 静态方法用于初始化
  static Future<void> initialize() async {
    await _instance._init();
  }

  /// 保存 String 类型的值
  Future<bool> saveString(String key, String value) async {
    return _prefs.setString(key, value);
  }

  /// 获取 String 类型的值
  String? getString(String key) {
    return _prefs.getString(key);
  }

  /// 保存 int 类型的值
  Future<bool> saveInt(String key, int value) async {
    return _prefs.setInt(key, value);
  }

  /// 获取 int 类型的值
  int? getInt(String key) {
    return _prefs.getInt(key);
  }

  /// 保存 double 类型的值
  Future<bool> saveDouble(String key, double value) async {
    return _prefs.setDouble(key, value);
  }

  /// 获取 double 类型的值
  double? getDouble(String key) {
    return _prefs.getDouble(key);
  }

  /// 保存 bool 类型的值
  Future<bool> saveBool(String key, bool value) async {
    return _prefs.setBool(key, value);
  }

  /// 获取 bool 类型的值
  bool? getBool(String key) {
    return _prefs.getBool(key);
  }

  /// 保存 List<String> 类型的值
  Future<bool> saveStringList(String key, List<String> value) async {
    return _prefs.setStringList(key, value);
  }

  /// 获取 List<String> 类型的值
  List<String>? getStringList(String key) {
    return _prefs.getStringList(key);
  }

  /// 删除指定 key 的值
  Future<bool> remove(String key) async {
    return _prefs.remove(key);
  }

  /// 清空所有存储的数据
  Future<bool> clearAll() async {
    return _prefs.clear();
  }

}