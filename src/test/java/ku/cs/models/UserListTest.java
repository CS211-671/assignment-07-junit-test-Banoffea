package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {

    @Test
    @DisplayName("User should be found in UserList")
    public void testUserListFindUser() {
        // TODO: add 3 users to UserList
        UserList userList = new UserList();
        userList.addUser("user1", String.valueOf(1111));
        userList.addUser("user2", String.valueOf(2222));
        userList.addUser("user3", String.valueOf(3333));
        // TODO: find one of them
        User user = userList.findUserByUsername("user2");
        // TODO: assert that UserList found User
        // String expected = "<one of username>";
        // String actual = user.getUsername();
        // assertEquals(expected, actual);
        assertEquals("user2",user.getUsername());
    }

    @Test
    @DisplayName("User can change password")
    public void testUserCanChangePassword() {
        // TODO: add 3 users to UserList
        UserList userList = new UserList();
        userList.addUser("user1", "1111");
        userList.addUser("user2", "2222");
        userList.addUser("user3", "3333");
        // TODO: change password of one user
        boolean isPasswordCorrect = userList.changePassword("user2", "2222", "2233");
        // TODO: assert that user can change password
        assertTrue(isPasswordCorrect);
        User user = userList.login("user1", "1122");
        assertNotNull(user);
        assertEquals("user1", user.getUsername());
    }

    @Test
    @DisplayName("User with correct password can login")
    public void testUserListShouldReturnObjectIfUsernameAndPasswordIsCorrect() {
        // TODO: add 3 users to UserList
        UserList userList = new UserList();
        userList.addUser("user1", "1111");
        userList.addUser("user2", "2222");
        userList.addUser("user3", "3333");
        // TODO: call login() with correct username and password
        User user = userList.login("user1", "1111");
        // TODO: assert that User object is found
        // assertEquals(expected, actual);
        assertNotNull(user);
        assertEquals("user1", user.getUsername());
    }

    @Test
    @DisplayName("User with incorrect password cannot login")
    public void testUserListShouldReturnNullIfUsernameAndPasswordIsIncorrect() {
        // TODO: add 3 users to UserList
        UserList userList = new UserList();
        userList.addUser("user1", "1111");
        userList.addUser("user2", "2222");
        userList.addUser("user3", "3333");
        // TODO: call login() with incorrect username or incorrect password
        User user = userList.login("user1", "4455");
        // TODO: assert that the method return null
        assertNull(user);
    }

    @Test
    public void testAddUser() {
        UserList userList = new UserList();
        userList.addUser("user1", "password1");

        User addedUser = userList.findUserByUsername("user1");

        assertNotNull(addedUser);
        assertEquals("user1", addedUser.getUsername());
    }
}
