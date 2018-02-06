package accountsServices

import scala.collection.mutable

object UserDatabase {

    val userMap: mutable.Map[Long, User] = scala.collection.mutable.Map(123456 -> User("neel", 123456, "neel21","neel21"))

  val userToken : mutable.Map[Long,String] = scala.collection.mutable.Map(123456 -> "NEEL")

}

class UserAccounts extends accounts {
  def addUser(username: String, mobileNumber: Long, password: String, confirmPassword: String): String = {

    if (UserDatabase.userMap.contains(mobileNumber)) {
      s"user $username is already exist"
    }
    else if (password != confirmPassword) {
      " password and confirmPassword need to be same for registration"
    }
    else {
      UserDatabase.userMap += (mobileNumber -> User(username, mobileNumber, password, confirmPassword))
      " user registered successfully"
    }
  }

  def validateUser(username: String, password: String): String = {

    val validator = for{(key,userRecord)<-UserDatabase.userMap
                        status=if(userRecord.userName==username && userRecord.password==password)true
                        else false
    }yield(key,status)

    val UserStatusList = validator.values.toList
    if(UserStatusList.contains(true))
    {
      val index = UserStatusList.indexOf(true)
      val mobileNumber = validator.toList(index)._1
      val token = username.toUpperCase
      UserDatabase.userToken += (mobileNumber->token)
      token
    }
    else
      " "
  }

}
