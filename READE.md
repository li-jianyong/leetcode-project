记录2021.4.20 重新学习git相关命令，并做记录
	git pull命令更适合理解成，将哪些修改添加到下一次commit提交里!!!
        git pull 抓取远端分支并合并到当前分支的组合命令
    git rm 文件名 --cached 将文件从暂存区移除，恢复成未跟踪状态，从暂存区域移除工作区保留
    本地工作删除文件后，git status查看该文件处于未提交的删除状态，直接通过commit进行提交
        git rm 文件名 删除工作区和暂存区
        git rm 文件名 --cached 从暂存区移除，工作区保留
        rm 文件名 工作区移除，暂存区保留
    
    git log
        git log --pretty=format:"%h - %an, %ar : %s"按照指定的格式显示git日志历史记录形式

    git commit --amend
        使用场景，第一次提交后，发现有些东西没改完，原本操作又要修改再提交一次，就会有两条提交历史，
            正确做法，第二次提交时候，使用git commit --amend进入交互界面修改message信息，那么第一次的提交记录就没有了，相当于合并到
            同一个提交里了；
    
    git checkout -- 文件名 将指定文件名的文件恢复到刚克隆完的样子，会用最近提交的版本覆盖掉它

    git tag 分为轻量级别标签，和标注标签，同样是使用git push origin 标签名 将标签推送到远端
        git push origin --delete 标签名 删除标签的动作推送到远端
    git merge
    当两个分支在一条线上，可以通过指针前移动到达时，会执行fast-forward合并
    测试1
    测试2