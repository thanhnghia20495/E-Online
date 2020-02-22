package com.web.EOnline.services;

import com.web.EOnline.entities.Scripts;

public interface ScriptService {
	Scripts findScriptByDescription(String description);

	Scripts createScript(Scripts script);

	Scripts updateScript(Scripts script);


}
