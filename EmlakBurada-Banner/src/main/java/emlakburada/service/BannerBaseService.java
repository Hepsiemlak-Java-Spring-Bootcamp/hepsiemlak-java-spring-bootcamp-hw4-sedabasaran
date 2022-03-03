package emlakburada.service;

import emlakburada.dto.request.BannerRequest;
import emlakburada.dto.response.BannerResponse;
import emlakburada.model.Banner;

public class BannerBaseService {
	
	protected BannerResponse convertToBannerResponse(Banner banner) {
		BannerResponse response = new BannerResponse();
		response.setAdvertNo(banner.getAdvertNo());
		response.setPhone(banner.getPhone());
		response.setTotal(banner.getTotal());
		return response;
	}

	protected Banner convertToBanner(BannerRequest request) {
		Banner banner = new Banner();
		banner.setAdvertNo(request.getAdvertNo());
		banner.setPhone(request.getPhone());
		banner.setTotal(request.getTotal());
		return banner;
	}

}
