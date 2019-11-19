package com.web.EOnline.services;

import com.web.EOnline.entities.Statuses;

public interface StatusService {
	Statuses findStatusById(int statusCode);

	Statuses createStatus(Statuses Status);

	Statuses updateStatus(Statuses Status);


}
