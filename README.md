/src/main/resources/
に application.properties を作成し下記を書き込む
```
spring.application.name=sample
spring.datasource.url=jdbc:mysql://localhost:3306/{データベース名}
spring.datasource.username={ユーザ名}
spring.datasource.password={パスワード}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
```
