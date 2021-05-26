
package com.nagarro.services;

import com.nagarro.interfaces.ImageManagementInterface;
import com.nagarro.model.Image;
import com.nagarro.hibernate.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

@SuppressWarnings("deprecation")
public class ImageManagementImplementation implements ImageManagementInterface {

	@Override
	public void addImage(Image image) {
		try (Session session = HibernateUtil.getSessionInstance();) {
			session.getTransaction().begin();
			session.save(image);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Image getImage(String imageId) {
		Image image = null;
		try (Session session = HibernateUtil.getSessionInstance();) {
			session.getTransaction().begin();
			String queryString = "from Image where imageId = :imageId";
			@SuppressWarnings("rawtypes")
			Query query = session.createQuery(queryString).setString("imageId", imageId);

			Object queryResult = query.uniqueResult();
			return (Image) queryResult;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Unable to connect to database");
		}
		return image;
	}

	@Override
	public void editImage(Image newImage) {
		try (Session session = HibernateUtil.getSessionInstance();) {
			session.beginTransaction();
			session.update(newImage);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteImage(String imageid) {
		try (Session session = HibernateUtil.getSessionInstance();) {
			session.beginTransaction();

			String query = "delete from Image where imageId= :imageId";
			session.createQuery(query).setString("imageId", imageid).executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteDetails(int id) {
		Session session = HibernateUtil.getSessionInstance();
		session.beginTransaction();
		Image userDetail = new Image();
		userDetail.setImageId((long) id);
		session.delete(userDetail);
		session.getTransaction().commit();
		session.close();

	}

	public static void updateDetails(int id, String newImageName, byte[] newImageSource, long l) {
		Session session = HibernateUtil.getSessionInstance();
		session.beginTransaction();
		Image newDetails = session.get(Image.class, (long) id);
		newDetails.setImageName(newImageName);
		newDetails.setPhoto(newImageSource);
		newDetails.setImageSize(l);
		session.update(newDetails);
		session.getTransaction().commit();
		session.close();

	}
}