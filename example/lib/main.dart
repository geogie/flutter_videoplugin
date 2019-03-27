import 'package:flutter/material.dart';
import 'dart:async';

import 'package:flutter/services.dart';
import 'package:flutter_videoplugin/flutter_videoplugin.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  var viewPlayerController;
  @override
  void initState() {
    super.initState();
  }

  void onViewPlayerCreated(viewPlayerController) {
    this.viewPlayerController = viewPlayerController;
    this.viewPlayerController.loadUrl("http://xxxx.mp4");//记得换为自己的网络地址
  }

  @override
  Widget build(BuildContext context) {

    var x = 0.0;
    var y = 0.0;
    var width = 400.0;
    var height = width * 9.0 / 16.0;

    BmsVideoPlayer videoPlayer = new BmsVideoPlayer(
        onCreated: onViewPlayerCreated,
        x: x,
        y: y,
        width: width,
        height: height
    );
    print('fcs-flutter-main');
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Column(
          children: <Widget>[
            Container(
                child: videoPlayer,
                width: width,
                height: height
            ),
            InkWell(
              child: Text("开始播放"),
              onTap: (){
                print('fcs-开始播放');
                this.viewPlayerController.start();
              },
            )
          ],
        )
      ),
    );
  }
}
