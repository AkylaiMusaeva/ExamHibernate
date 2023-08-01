package peaksoft.service;

import peaksoft.entity.Profile;

public interface ProfileService {
   String saveProfile(Long userId, Profile profile);

    String assignProfileToUser(Long profileId, Long userId);

    String updateUserProfile(Long userId, Profile profile);

    Profile findProfileByUserId(Long id);

    String deleteProfileByUserId(Long userId);
}
