package ua.com.alevel.generic;

import com.google.gson.Gson;
import ua.com.alevel.data.User;

public class GenericTest {

    public void test() {
        User user = new User(1, "test");
        DataContainer<User> container = new DataContainer<>();
        ResponseContainer<User> responseContainer = new ResponseContainer<>();
        responseContainer.setRes(user);
        responseContainer.setError(false);
        responseContainer.setMessage("something");
        container.setData(responseContainer);
        Gson gson = new Gson();
        String json = gson.toJson(container);
        System.out.println("json = " + json);

        MathUtil mathUtil = new MathUtil();
        mathUtil.sum(1L, 1.0, 1, 1.0d);
    }
}
