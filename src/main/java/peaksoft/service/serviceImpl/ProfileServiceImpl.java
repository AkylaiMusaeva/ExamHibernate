package peaksoft.service.serviceImpl;

import peaksoft.entity.Profile;
import peaksoft.repository.ProfileRepo;
import peaksoft.repository.repoImpl.ProfileRepoImpl;
import peaksoft.service.ProfileService;

public class ProfileServiceImpl implements ProfileService {
    ProfileRepo profileRepo=new ProfileRepoImpl();
    @Override
    public String saveProfile(Long userId, Profile profile) {
        profileRepo.saveProfile(userId,profile);
        return profile.getFullName()+" is successfully saved!";
    }

    @Override
    public String assignProfileToUser(Long profileId, Long userId) {
        profileRepo.assignProfileToUser(profileId,userId);
        return "Successfully assigned profile to user!";
    }

    @Override
    public String updateUserProfile(Long userId, Profile profile) {
        profileRepo.updateUserProfile(userId,profile);
        return "Successfully updated user's profile with id ="+userId;
    }

    @Override
    public Profile findProfileByUserId(Long id) {
        return profileRepo.findProfileByUserId(id);
    }

    @Override
    public String deleteProfileByUserId(Long userId) {
        profileRepo.deleteProfileByUserId(userId);
        return userId+" his profile is successfully deleted!";
    }
}
