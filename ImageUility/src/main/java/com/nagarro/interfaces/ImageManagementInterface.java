package com.nagarro.interfaces;

import com.nagarro.model.Image;

public interface ImageManagementInterface {

    void addImage(Image image);

    Image getImage(String imageid);

    void editImage(Image newImage);

    void deleteImage(String imageid);
    
}