**Задание № 1**

***Создаем файл с домашними животными***

user@fv4788umrms25brka0r7:~$ cat > home_animals\
Dog\
Cat\
hamster\

***Создаем файл с вьючными животными***

user@fv4788umrms25brka0r7:~$ cat > pack_animals\
horses\
camels\
donkeys\

***Посмотрели, что файлы созданы***

user@fv4788umrms25brka0r7:~$ ls -l\
total 12\
-rw-rw-r-- 1 user user 17 Apr  2 16:09 home_animals\
-rw-rw-r-- 1 user user 23 Apr  2 16:13 pack_animals\

***Конкатенация файлов***

user@fv4788umrms25brka0r7:~$ cat home_animals pack_animals > animals

***Просмотр файла***

user@fv4788umrms25brka0r7:~$ cat animals\
Dog\
Cat\
hamster\
horses\
camels\
donkeys\

***Переименовываем файл***

user@fv4788umrms25brka0r7:~$ mv animals human_friends

**Задание № 2**

user@fv4788umrms25brka0r7:~$ mkdir Human_Friends

user@fv4788umrms25brka0r7:~$ mv human_friends ~/ Human_Friends

user@fv4788umrms25brka0r7:~$ ls Human_Friends human_friends

**Задание № 3**

***Загружаем репозиторий***

user@fv4788umrms25brka0r7:~$ wget https://dev.mysql.com/get/mysql-apt-config_0.8.24-1_all.deb

***Смотрим информацию о конфигурации***

user@fv4788umrms25brka0r7:~$ sudo dpkg -i mysql-apt-config_0.8.24-1_all.deb

***Проверяем список пакетов***

user@fv4788umrms25brka0r7:~$ sudo apt-get update

***Подключение***

user@fv4788umrms25brka0r7:~$ sudo apt-get install mysql-server

**Задание № 4**

***Загружаем deb пакет***

user@fv4788umrms25brka0r7:~$ wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb

***Установка***

user@fv4788umrms25brka0r7:~$ sudo dpkg -i google-chrome-stable_current_amd64.deb

***Находим пакет***

user@fv4788umrms25brka0r7:~$ sudo dpkg -S /usr/bin/google-chrome-stable

***Удаляем***

user@fv4788umrms25brka0r7:~$ sudo dpkg --purge google-chrome-stable


