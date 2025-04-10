import 'package:pub_reader/common/mocked_data.dart';
import 'package:pub_reader/common/models/book_model.dart';

class BookApi {

  BookApi._();

  static Future<List<Book>> getBookList({int page = 1, keyword="people"}) async {
    return MockedData.mockBooks(10);
  }
  
}