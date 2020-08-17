#创建 .git 文件夹 

git init 



#链接远端Git服务器 

git remote add origin https://gitee.com/XXXXXXXXXX



#克隆远端Git服务器 

git clone https://gitee.com/xxxx 



#注册用户信息 

git config --global user.name "用户1" 

git config --global user.email "xxx@xxxx.com" 



#将当前目录所有文件添加到git暂存区 

git add . 



#提交并备注提交信息 

git commit -m "%date%%time% " 



#将本地提交推送到远程仓库 

git push origin master 



#出现问题时，强制将本地提交推送到远程仓库 

git push -f origin master 



#将远程仓库更新到本地 

git pull origin master