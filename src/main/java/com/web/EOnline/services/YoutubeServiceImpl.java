package com.web.EOnline.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.EOnline.entities.Youtube;
import com.web.EOnline.repositories.YoutubeRepository;

@Service
public class YoutubeServiceImpl implements YoutubeService {

	@Autowired
	YoutubeRepository youtubeRepository;

	@Override
	public Youtube createYoutube(Youtube youtube) {
		try {
			return youtubeRepository.save(youtube);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Youtube updateYoutube(Youtube youtube) {
		try {
			return youtubeRepository.save(youtube);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
