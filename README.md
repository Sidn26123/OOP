# OOP
//Trên laptop
git init

git add .

git commit -m "Ghi chú"

//Lấy code về từ link
git clone https://github.com/Sidn26123/OOP.git

//Clone 1 branch cụ thể
git clone -b <ten-branch> https://github.com/Sidn26123/OOP.git

Tạo và chuyển sang branch mới
```
*a
git branch

git branch <ten branch moi>

git checkout <ten branch>

git checkout -b <ten branch moi>


```

Cập từ từ local lên github

```
  git remote add origin https://github.com/Sidn26123/OOP (thêm url, tên origin)

  git push origin <ten branch>  
```


Gộp
```
  git checkout master/main

  git merge <ten branch>

```

Cập nhật thay đổi từ master trên github sang máy local
```
  git pull origin master
```
