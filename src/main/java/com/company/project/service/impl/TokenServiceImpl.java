package com.company.project.service.impl;

import org.springframework.stereotype.Service;

import com.company.project.service.TokenService;

/**
 * @author duanzhiwei
 *
 */
@Service
public class TokenServiceImpl implements TokenService {
//    @Autowired
//    IRedisCache redisCache; 
//	@Autowired
//	private JSONValueOperation operations;
//	/**
//	 * TODO 简单描述该方法的实现功能（可选）.
//	 * @see com.company.project.service.TokenService#getTokenKey(java.lang.String)
//	 */
//	@Override
//	public String getTokenKey(String token) {
//		return ProjectConstant.TOKEN_CACHE_PRIFIX + token;
//	}
//	
//	/* (non-Javadoc)
//	 * @see com.wiselong.callcenter.service.TokenService#cacheUserInfo(com.wiselong.callcenter.domain.dto.UserInfoDTO)
//	 */
//	@Override
//	public String cacheUserInfo(UserInfoDTO userInfo) {
//		String token = UUID.randomUUID().toString();
////		redisCache.set(getTokenKey(token), userInfo, ProjectConstant.TOKEN_EXPIRETIME);
//		operations.set(getTokenKey(token), userInfo, 1800L);
//		return token;
//	}
//	
//	/* (non-Javadoc)
//	 * @see com.company.project.service.impl.TokenService#tokenValidate(java.lang.String)
//	 */
//	@Override
//	public boolean tokenValidate(String token) {
//		if (StringUtils.isNotBlank(token)) {
//			return getUserInfoFromCache(token) != null;
//		}
//		return false;
//	}
//	
//	/* (non-Javadoc)
//	 * @see com.company.project.service.impl.TokenService#resetCacheTime(java.lang.String)
//	 */
//	@Override
//	public String resetCacheTime(String token) {
//		//TODO
//		return token;
//	}
//	
//	/* (non-Javadoc)
//	 * @see com.company.project.service.impl.TokenService#getUserInfoFromCache(java.lang.String)
//	 */
//	@Override
//	public UserInfoDTO getUserInfoFromCache(String token) {
//		return operations.get(getTokenKey(token), UserInfoDTO.class);
////		return redisCache.get(getTokenKey(token), UserInfoDTO.class);
//	}
}
