package emlakburada.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import emlakburada.dto.AdvertRequest;
import emlakburada.dto.response.AdvertResponse;
import emlakburada.model.Advert;
import emlakburada.model.User;
import emlakburada.repository.AdvertRepository;

public class AdvertBaseService {
	
	@Autowired
	private AdvertRepository advertRepository;

	private static int advertNo = 38164784;

	
	protected AdvertResponse convertToAdvertResponse(Advert savedAdvert) {
		AdvertResponse response = new AdvertResponse();
		response.setBaslik(savedAdvert.getBaslik());
		response.setFiyat(savedAdvert.getFiyat());
		response.setAdvertNo(savedAdvert.getAdvertNo());
		response.setKullanici(savedAdvert.getCreatorUser());
		return response;
	}

	protected Advert convertToAdvert(AdvertRequest request, Optional<User> foundUser) {
		// Advert advert = new Advert(new RealEstate(), new User(), new String[5]);

		Advert advert = null;

		if (foundUser.isPresent()) {
			advert = new Advert();
			advert.setCreatorUser(foundUser.get());
			advertNo++;

			advert.setAdvertNo(advertNo);
			advert.setBaslik(request.getBaslik());
			advert.setFiyat(request.getFiyat());
		} else {
			log.info("Kullanıcı Bulunamadı!");
		}

		return advert;
	}

	public AdvertResponse getAdvertByAdvertId(int advertId) {
		Optional<Advert> advert = advertRepository.findById(advertId);
		return convertToAdvertResponse(advert.get());
	}
	
	public AdvertResponse deleteAdvertByAdvertById(int advertId) {
		Optional<Advert> advert=advertRepository.findById(advertId);
		return convertToAdvertResponse(advert.get());
		
	}

}
