package peaksoft.repository;

import peaksoft.entity.Profile;

public interface ProfileRepo {
    void saveProfile(Long userId, Profile profile);

    void assignProfileToUser(Long profileId, Long userId);

    void updateUserProfile(Long userId, Profile profile);

    Profile findProfileByUserId(Long id);

    void deleteProfileByUserId(Long userId);
}
