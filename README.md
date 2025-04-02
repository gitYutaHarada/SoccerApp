# サッカー試合掲示板

## 1. プロジェクト概要

### プロジェクト名
**サッカー試合掲示板**

### 目的
私はレアル・マドリードが好きで毎試合観戦しています。しかし、海外サッカーはJリーグと違い、現地観戦が難しく、同じチームのサポーターと交流する場が少ないと感じました。  
そこで、試合ごとにコメントを投稿したり、選手の評価を共有したりすることで、サポーター同士が交流できる掲示板を作成しました。

また、Javaでアプリケーションを作成した経験はありましたが、フレームワークを使用した開発は未経験だったため、Spring Bootを学びながら開発しました。

---

## 2. 主な機能

| ユーザー種別 | 機能 |
|-------------|--------------------------------|
| **管理者** | チームの登録、チーム画像の登録、選手の登録、試合の登録 |
| **一般ユーザー** | 新規登録、お気に入りチームの登録、試合ごとのコメント追加、他ユーザーのコメント参照、試合ごとの選手評価追加、選手ごとの平均評価の参照 |

---

## 3. 使用技術

- **言語・フレームワーク**: Java, Spring Boot, Thymeleaf, HTML, CSS
- **データベース**: MySQL
- **その他**: Lombok,

---

## 4. 技術的チャレンジ
- **MySQLに画像ファイルを保存し、HTMLで表示する処理を実装**
- **Spring Bootを活用し、MVCアーキテクチャを学習しながら開発**
---
## 5. データベース設計

このアプリでは、試合情報やユーザーのコメントを管理するために **MySQL** を使用しています。

### ER図
以下のER図は、本アプリのデータベース設計を示しています。
https://github.com/gitYutaHarada/SoccerApp/blob/main/%E3%82%B9%E3%82%AF%E3%83%AA%E3%83%BC%E3%83%B3%E3%82%B7%E3%83%A7%E3%83%83%E3%83%88%202025-03-21%20143005.png

### 主なテーブル
| テーブル名 | 説明 |
|------------|------------------------------------------------|
| **users** | ユーザー情報（ユーザー名、パスワード、ロール） |
| **teams** | チーム情報（チーム名、チーム画像） |
| **games** | 試合情報（ホームチーム、アウェイチーム、スコア） |
| **players** | 選手情報（選手名、背番号、所属チーム） |
| **comments** | 試合ごとのコメント（ユーザー、試合、コメント内容） |
| **likes** | コメントへのいいね（ユーザー、コメントID） |
| **player_game_ratings** | 選手ごとの試合評価（ユーザー、試合、選手、評価点） |
| **average_ratings** | 選手ごとの平均評価（試合、選手、平均スコア） |
