package infrastracture

import java.io.FileWriter
import java.nio.file.{Files, Paths}

import domain.tweet.{ITweetRepository, Tweet}

class TweetFileRepository extends ITweetRepository{
  override def save(tweets: Seq[Tweet]): Unit = {
    val file = Paths.get("conf/ochiai_auto_tweets/tmp/" + tweets.head.getSenderId() + "tweet.txt")
    if(Files.notExists(file)) Files.createFile(file)

    val fileInputWriter = new FileWriter(file.toFile)
    tweets.foreach(tweet => fileInputWriter.write(tweet.getBody().replace(System.getProperty("line.separator"), "") + System.getProperty("line.separator")))
    fileInputWriter.close()
  }
}
