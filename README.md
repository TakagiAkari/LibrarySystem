### データベース初期状態にする(初回のみ)

powershellを起動します。

`cd /Eclipse_JAVA/workspace/LibrarySystem`

`psql -U postgres`

`\i initialize.sql`

### データベースを初期状態にする

powershellを起動します

`cd /Eclipse_JAVA/workspace/LibrarySystem`

`psql library_system admin`

`\i start.sql`