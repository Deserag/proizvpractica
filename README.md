# proizvpractica
Сервис для загрузки excel файла с определенной переодичностью, и данные из файла записываются в Redmine


Для реализации требуется декомпозировать работу, для начала требуется разработать шаблоны excel файла, из которых будут браться информация. Для получения информации требуется разработать парсер на java, который будет получать информацию.
После создания парсера и его тестирвоания, создается REST HTTP сервис, который будет работать в определенное время.
Далее происходит подключение к Redmine, в который будет заносится информация, полученная из excel файла.


Работа с excel файлом и парсер. Для корректной работы требуется создать excel файл, в котором информация будет структурирована, находится рядом и по возможности распределять информацию. В работе парсера требуется для начала выбрать наиболее подходящий шаблон, из которого будет браться информация. После этого требуется вывести информацию, и при возможности информацию или ее часть распределять в отдельные значения, которые в последствие будут автоматически заносится в разные поля.

REST HTTP сервис, требуется для подключения и работе парсера, чтобы запускать его в определенное время.

В Redmine, будет заносится информация, полученная из парсинга файла

#Информация о том, как выполняется в ходе выполнения практики будет корректироваться и изменяться.
