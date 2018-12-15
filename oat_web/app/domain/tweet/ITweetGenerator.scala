package domain.tweet

trait ITweetGenerator {
  def generateTweet(twitterId: String): Tweet
}
