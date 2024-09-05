import 'package:flutter/services.dart';

class AidlService {
  static const MethodChannel _channel = MethodChannel('com.example.myapp/aidl');

  static Future<int> add(int a, int b) async {
    final int result = await _channel.invokeMethod('add', {'x': a, 'y': b});
    return result;
  }
}
