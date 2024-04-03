Создаем файл с домашними животными
user@fv4788umrms25brka0r7:~$ cat > home_animals
Dog
Cat
hamster

Создаем файл с вьючными животными
user@fv4788umrms25brka0r7:~$ cat > pack_animals
horses
camels
donkeys

Посмотрели, что файлы созданы
user@fv4788umrms25brka0r7:~$ ls -l
total 12
-rw-rw-r-- 1 user user 17 Apr  2 16:09 home_animals
-rw-rw-r-- 1 user user 23 Apr  2 16:13 pack_animals

Конкатенация файлов
user@fv4788umrms25brka0r7:~$ cat home_animals pack_animals > animals

Просмотр файла 
user@fv4788umrms25brka0r7:~$ cat animals
Dog
Cat
hamster
horses
camels
donkeys

Переименовываем файл
user@fv4788umrms25brka0r7:~$ mv animals human_friends
