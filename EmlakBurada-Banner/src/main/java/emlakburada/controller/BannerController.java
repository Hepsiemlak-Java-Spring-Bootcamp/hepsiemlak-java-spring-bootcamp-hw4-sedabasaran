package emlakburada.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import emlakburada.dto.request.BannerRequest;
import emlakburada.dto.response.BannerResponse;
import emlakburada.service.BannerService;

@RestController
public class BannerController {

	@Autowired
	private BannerService service;

	@GetMapping("/banners")
	public ResponseEntity<List<BannerResponse>> getAllBanners() {
		service.getAllBanners();
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/banners")
	public ResponseEntity<BannerResponse> saveBanner(@RequestBody BannerRequest request) {
		service.saveBanner(request);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
