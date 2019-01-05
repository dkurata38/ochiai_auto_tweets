package domain.tweet

trait ITweetGenerator {
  def generateTweet(twitterId: String): Either[String, Tweet]
}
