package application.tweet

import domain.tweet._
import javax.inject.{Inject, Singleton}

@Singleton
class TweetUseCase @Inject()(tweetClient: ITweetClient, tweetRepository: ITweetRepository, tweetGenerator: ITweetGenerator) {
  def generateTweet(token: String, secret: String, twitterId: String): Either[String, Tweet] = {
    val tweets = tweetClient.getUserTimeline(token: String, secret: String, twitterId)
    if (tweets.isSuccess) {
      val src = tweets.get
      tweetRepository.save(src)
      tweetGenerator.generateTweet(src.head.getSenderId())
    }
    Left("エラーです")
  }

  def postTweet(token: String, secret: String, tweetText:String) = {
    val tweet: Tweet = Tweet.createNewTweet(tweetText)
    tweetClient.updateStatus(token, secret, tweet)
  }
}
