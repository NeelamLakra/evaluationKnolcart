package accountsServices

trait accounts {

  def addUser(username: String, mobileNumber: Long, password: String, confirmPassword: String): String
  def validateUser(username: String, password: String): String
}