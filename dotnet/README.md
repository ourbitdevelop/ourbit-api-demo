# Ourbit DotNet Demo

Before you use the demo, you need to generate your apikey & apisecret, then enter them first.

* <https://www.ourbit.com/user/openapi>

## Spot V3 Demo 

Fill in the corresponding function according to the parameters mentioned in the API documentation and execute it. => `dotnet run`

**Rest API V3 doc**   `URL = 'https://api.ourbit.com'`

* <https://ourbitdevelop.github.io/apidocs/spot_v3_cn/#45fa4e00db>


> ### Example(Spot V3) :

Use Program.cs as a test example

```csharp
static async Task Main(string[] args)
{
   if (args.Count() == 0)
      throw new ArgumentException($"Command missing. Accept commands: signature, market, trade, account, subaccount, margin");

   string apiKey = "your apikey";
   string apiSecret = "your secret";
   string BaseUrl = "https://api.ourbit.com";

   HttpClient httpClient = new HttpClient();
   switch (args[0])
   {
     case "market": await Market(new OurbitService(apiKey, apiSecret, BaseUrl, httpClient)); break;
   }
}
private static async Task Market(OurbitService OurbitService)
{
   using (var response = OurbitService.SendPublicAsync("/api/v3/klines", HttpMethod.Get, new Dictionary<string, object> {
                {"symbol", "BTCUSDT"}, {"interval", "1d"}, {"limit", 5}
   }))
   {
     Console.WriteLine(await response);
   };
}
```
`dotnet run market`

## Spot Websocket Demo 

According to the information you want to subscribe, change the content of the params according to the websocket documentation, ex: "op" or "symbol".   Execute the entire file after adjusting the parameters.



**WebSocket doc**   `URL = 'wss://wbs.ourbit.com/raw/ws'`

* <https://ourbitdevelop.github.io/apidocs/spot_v2_cn/#websocket-api>


`dotnet run`


