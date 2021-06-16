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

## 作業中のブランチを最新にする

'git fetch origin master'

'git merge origin master'

## ブランチで編集した情報を反映させてpullRequestを送る

'git add (編集したファイル名)'

'git commit -m "コメント"

'git push origin (ブランチ名)'

github上でpullRequestを送る
