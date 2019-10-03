# Android_example_View02
其一：处理开机接收广播 响应    其二：判断 网络状态
    
    其三：添加无序广播 发送  可在disOrderBroadCast 中做处理
    
     其四：广播可做跨进程处理！ 
     
     实战部分 -> 使用广播强制下线！
            操作步骤： 1.新建moudle
                      2.添加 ActivityController 去管理activity
                       3.添加一个baseActivity 用来移除和添加activity
                        4.新建loginActivity 并且添加admin 和 pwd 布局
                          5.添加admin为123456为登陆成功 -> 点击登录 跳转主页面，主页面只有一个按钮
                            6.点击按钮弹出dialog 接着点击dialog去 清除所有activity 并且跳转到LoginActivity
                              7.测试Ok
                             
      
      --------------------------------------- 
      2019年10月3日09点44分 更新 SharePerferences 记住密码功能
                             
          