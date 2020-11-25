AndroidStudio使用教程(第三弹)
===

熟悉了基本的使用之后，可能关心的就是版本控制了。

- `SVN`               
    - 下载`Subversion command line`              
		- 方法一                
	        下载地址是[Subversion](http://subversion.apache.org/packages.html)里面有不同系统的版本。             
	        以`Windows`为例，我们采用熟悉的`VisualSVN`.                    
	        ![AndroidStudio_3_1](https://gitee.com/xj36/chart-bed-test/raw/master/static/AndroidStudio_3_1.png)	                     
	        进入下载页后下载`Apache Subversion command line tools`, 解压即可。             
		    ![AndroidStudio_3_2](https://gitee.com/xj36/chart-bed-test/raw/master/static/AndroidStudio_3_2.png)        
        - 方法二                                   
	      `Windows`下的`Tortoise SVN`也是带有`command line`的，但是安装的时候默认是不安装这个选项的，所以安装时要注意选择一下。                  
		  ![AndroidStudio_3_5](https://gitee.com/xj36/chart-bed-test/raw/master/static/AndroidStudio_3_5.png)                 
			选择安装即可                         
			![AndroidStudio_3_6](https://gitee.com/xj36/chart-bed-test/raw/master/static/AndroidStudio_3_6.png)             
		
	- 配置`SVN`                      
	    进入设置中心,搜索`Version Control`后选择`Subversion`， 将右侧的`Use command line client`设置你本地的`command line`路径即可。             
		![AndroidStudio_3_3](https://gitee.com/xj36/chart-bed-test/raw/master/static/AndroidStudio_3_3.png)             	
		如果是用第二种方式安装`Tortoise SVN`的话地址就是：                   
		![AndroidStudio_3_4](https://gitee.com/xj36/chart-bed-test/raw/master/static/AndroidStudio_3_4.png)               
		PS: 设置成自己的路径啊，不要写我的...               
	
- `Git`
	安装`Git`, [Git](http://git-scm.com/)             
	选择相应系统版本安装即可。                   
	安装完成后进入`Android Studio`设置中心-> `Version Control` -> `Git`设置`Path to Git executable`即可。                 
	![AndroidStudio_3_7](https://gitee.com/xj36/chart-bed-test/raw/master/static/AndroidStudio_3_7.png)           

- `Github`
    怎么能少了它呢？哈哈              
	这个就不用安装了，直接配置下用户名和密码就好了。                    
	![AndroidStudio_3_8](https://gitee.com/xj36/chart-bed-test/raw/master/static/AndroidStudio_3_8.png)          	
	
- `Checkout`
    在工具栏中点击 `VCS` 能看到相应检出和导入功能。这里以`Github`检出为例介绍一下。                   
	![AndroidStudio_3_9](https://gitee.com/xj36/chart-bed-test/raw/master/static/AndroidStudio_3_9.png)	           
	![AndroidStudio_3_10](https://gitee.com/xj36/chart-bed-test/raw/master/static/AndroidStudio_3_10.png)     
	确定之后就能在底部导航栏看到检出进度                    
	![AndroidStudio_3_11](https://gitee.com/xj36/chart-bed-test/raw/master/static/AndroidStudio_3_11.png)             
	
	完成之后会提示是否想要把刚才检出的项目导入`AndroidStudio`中。                  
	Why not?                         
	以`Gradle`方式导入， 然后`next`, 然后`next`然后就没有然后了。                     
	![AndroidStudio_3_12](https://gitee.com/xj36/chart-bed-test/raw/master/static/AndroidStudio_3_12.png)                                 
		

