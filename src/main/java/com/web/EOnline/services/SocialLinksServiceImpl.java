package com.web.EOnline.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.EOnline.entities.SocialLinks;
import com.web.EOnline.repositories.SocialLinksRepository;

@Service
public class SocialLinksServiceImpl implements SocialLinksService {

	@Autowired
	SocialLinksRepository socialLinksRepository;

	@Override
	public SocialLinks findSocialLinksByDescription(String description) {
		try {
			return socialLinksRepository.findByDescription(description);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public SocialLinks createSocialLinks(SocialLinks socialLinks) {
		try {
			return socialLinksRepository.save(socialLinks);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public SocialLinks updateSocialLinkst(SocialLinks socialLinks) {
		try {
			return socialLinksRepository.save(socialLinks);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
