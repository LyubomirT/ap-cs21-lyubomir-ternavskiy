# ap-cs21-lyubomir-ternavskiy
Waffle

> [!WARNING]
> На вінді можуть бути приколи з кодуванням, і проєкту для коду я не зробив (є тільки Main.java).
> Так що краще запускати через термінал і форсувати utf-8.
> Персонально я це зробив так у павершеллі (з кореня репозиторію):

```powershell
[Console]::InputEncoding = [System.Text.UTF8Encoding]::new($false)
[Console]::OutputEncoding = [System.Text.UTF8Encoding]::new($false)

java "-Dfile.encoding=UTF-8" "-Dstdout.encoding=UTF-8" task2/Main.java
```

^^ Оновив, воно працює краще за `chcp 65001`, хоча б в Павершеллі. У терміналі VSCode теж працює