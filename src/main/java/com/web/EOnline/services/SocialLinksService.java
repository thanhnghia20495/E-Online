package com.web.EOnline.services;

import com.web.EOnline.entities.SocialLinks;

public interface SocialLinksService {
	SocialLinks findSocialLinksByDescription(String description);

	SocialLinks createSocialLinks(SocialLinks socialLinks);

	SocialLinks updateSocialLinkst(SocialLinks socialLinks);

}
