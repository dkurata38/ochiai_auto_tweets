package infrastracture

import domain.tweet.{ITweetGenerator, Tweet}
import scala.sys.process._

class LocalTweetGenerator extends ITweetGenerator{
  override def generateTweet(twitterId: String): Either[String, Tweet] = {
    val fileName = s"conf/ochiai_auto_tweets/tmp/${twitterId}tweet.txt"
    val python_script_path = "conf/ochiai_auto_tweets/tweet_generator.py"

    try {
      val generated_text =
        Process(s"python $python_script_path $fileName").!!
      Right(Tweet.apply(generated_text, twitterId))
    } catch {
      case _: Exception => Left("失敗しました。")
    }
  }
}
