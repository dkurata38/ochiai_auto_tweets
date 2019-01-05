package domain.tweet

trait ITweetRepository {
  def save(tweets: Seq[Tweet])
}
