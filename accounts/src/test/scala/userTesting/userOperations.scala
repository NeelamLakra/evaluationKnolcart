package userTesting
import accountsServices._
import org.scalatest.FunSuite


class userOperations extends FunSuite {
  val user = new UserAccounts

    test("testing add User method"){
      assert(user.addUser("Ayush", 1234567, "Ayush03", "Ayush03")=== "Successfully registered!")
    }

    test("testing add User method for password and confirm password match case"){
      assert(user.addUser("neelam",1234 ,"neel87","neel43")=== "Password and Confirm Password do not match")
    }

    test("testing add User method for already registered mobile number"){
      assert(user.addUser("neel",123456, "neel21","neel21")==="User already registered")
    }

    test("testing authenticate account method that returns an access token"){
      assert(user.validateUser("neel", "neel21")==="NEEL")
    }

    test("testing authenticate account method that does not return an access token"){
      assert(user.validateUser("ayush", "2345")==="\0")
    }

  }


