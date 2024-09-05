import 'package:flutter/material.dart';
import 'package:flutter_android_aidl_example/AidlService.dart';

class Aidlservicescreen extends StatelessWidget {
  const Aidlservicescreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('AIDL Example'),
      ),
      body: Center(
        child: FutureBuilder<int>(
          future: AidlService.add(3, 4),
          builder: (context, snapshot) {
            if (snapshot.connectionState == ConnectionState.waiting) {
              return const CircularProgressIndicator();
            } else if (snapshot.hasError) {
              return Text('Error: ${snapshot.error}');
            } else {
              return Text('Sum: ${snapshot.data}');
            }
          },
        ),
      ),
    );
  }
}
