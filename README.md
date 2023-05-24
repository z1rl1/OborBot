# OborBot
В коде бота я изменил API токен.
Вот все мои скрипты:
1)ТАБЛИЦА АРЕНДА
CREATE TABLE "Аренда" (
	"IdArenda"	TEXT,
	"Длительность"	TEXT,
	"Цена"	TEXT
)
2)ТАБЛИЦА КАТЕГОРИИ
CREATE TABLE "Категории" (
	"IdKat"	TEXT,
	"Название категории"	TEXT
)
3)ТАБЛИЦА КЛИЕНТ 
CREATE TABLE "Клиент" (
	"IdKl"	INTEGER,
	"ChatId"	TEXT,
	"СпособОплаты"	TEXT,
	"IdObor"	TEXT,
	"IdOplata"	TEXT,
	FOREIGN KEY("IdOplata") REFERENCES "Оплата"("IdOplata"),
	FOREIGN KEY("IdObor") REFERENCES "Оборудование"("IdObor"),
	PRIMARY KEY("IdKl" AUTOINCREMENT)
)
4)ТАБЛИЦА ОБОРУДОВАНИЕ 
CREATE TABLE "Оборудование" (
	"IdObor"	TEXT,
	"Название"	TEXT,
	"Характеристика"	TEXT,
	"IdKat"	TEXT,
	FOREIGN KEY("IdKat") REFERENCES "Категории"("IdKat")
)
5)ТАБЛИЦА ОПЛАТА
CREATE TABLE "Оплата" (
	"IdOplata"	TEXT,
	"Цена"	TEXT,
	"IdArenda"	TEXT,
	"IdPol"	TEXT,
	FOREIGN KEY("IdPol") REFERENCES "Получение"("IdPol"),
	FOREIGN KEY("IdArenda") REFERENCES "Аренда"("IdArenda")
)
6)ТАБЛИЦА ПОЛУЧЕНИЕ 
CREATE TABLE "Получение" (
	"IdPol"	TEXT,
	"Способ"	TEXT
)

