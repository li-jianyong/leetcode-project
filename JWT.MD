前言：本篇总结下关于JWT的原理，以及使用，以便于后续对这项技术的理解和掌握！

技术产生背景：
    客户端与服务端通信过程，为了解决HTTP无状态的情形，出现了两种技术来维护这种状态
    1，session,session是服务端概念，客户端第一次使用账户密码进行登录，服务端生成session,然后将sessionid传给客户端，客户端将sessionid保存在本地会话cookie,
        服务端将对应sessionid保存在服务端，后续客户端每次通过请求都携带cookie,那么服务端可以从cookie种提取sessionid进行校验以及一些状态检测
        代价：服务端需要为每一位用户保存sessionid,空间消耗大
    2，token,服务端将不保存sessionid,将直接将token分发给客户端，客户端每次请求，进行token验证，如果token解密后，合法即为合法请求

来源：Json Web Token一种客户端的认证方式，客户端携带token来访问服务，服务对token进行校验，认证
token的格式：header + payload + signature 一共三部分组成的字符串
    以上header头部表明JWT类型，包含加密算法；{"type":"JTW","alg":"HS256"}
    payload 本质是用户数据，比如业务信息，属于对称加密归属于明文信息 
        { "iss": "JWT Builder","iat": 1416797419,"exp": 1448333419,"aud": "www.example.com",
        "sub": "aaa@example.com","Email": "aaa@example.com","Role": [ "admin", "user" ] }
    signature 签名 一般是用加密算法生成的一个能够认证身份的字符串，第三部分构成，第一部分base64 +　第二部分base64 用"."进行连接这两部分，然后通过header声明的加密方式
        进行加盐secret组合加密，最后拼接在字符串后面，完整的JWT;盐即服务端私钥不能泄露！
    
    那么相应地，服务端验证的token的流程，可以归纳为如下：
        拿到token先根据"."拆成三部分，拿到payload之后判断token是否失效，没失效，则根据第一部分标识的加密算法，对第一部分和第二部分再次进行加密算法，然后base64加密，
        然后验证结果和token第三部分的签名是否一致，如果一致，代表认证通过