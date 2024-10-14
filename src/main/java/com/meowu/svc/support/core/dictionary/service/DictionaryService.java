package com.meowu.svc.support.core.dictionary.service;

import com.meowu.svc.support.core.dictionary.entity.Dictionary;

import java.util.List;
import java.util.Map;

public interface DictionaryService{

    Dictionary save(Dictionary dictionary);

    Dictionary getById(Long id);

    List<Dictionary> findByGroupCode(String groupCode);

    Map<String, List<Dictionary>> findByGroupCodes(List<String> groupCode);
}
