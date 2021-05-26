  
package com.nagarro.servlets;

import com.nagarro.model.Image;
import com.nagarro.model.User;
import com.nagarro.services.LoginImplementation;

import java.util.Collection;


public class GetImagesSizes {

    public static double getImagesSize(String username) {
        double totalSize = 0;
        LoginImplementation login = new LoginImplementation();
        User user = (User) login.getUserDetails(username);
        Collection<Image> images = user.getImages();
        for (Image image : images) {
            totalSize += image.getImageSize();
        }
        return totalSize;
    }
}