package main

import (
	"demo/spot"
	"fmt"
)

//说明：
//在params中输入json格式的参数,如:`{"symbol":"BTCUSDT",	"limit":"200"}`
//如果没有参数则输入:""

//现货参数
// var params string = ""
var params string = `{}`

func main() {

	//接口调用
	ObDeduct := spotList.ObDeduct(params)
	fmt.Println("返回信息:", ObDeduct)

}
