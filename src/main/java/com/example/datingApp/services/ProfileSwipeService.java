package com.example.datingApp.services;

import com.example.datingApp.dtos.ProfileDto;
import com.example.datingApp.mappers.UserMapper;
import com.example.datingApp.models.City;
import com.example.datingApp.models.Profile;
import com.example.datingApp.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProfileSwipeService {

    private final FindByPreferenceService findByPreferenceService;
    private final CrudService<User> userService;
    private final UserMapper userMapper;

    public List<Profile> getSwipeList(int userId) {
        var userProfile = userService.findById(userId).getProfile();
        var preference = userProfile.getUser().getPreference();
        var city = userProfile.getCity();
        return findByPreferenceService.findByAgeGap(preference.getMinAge(),
                        preference.getMaxAge())
                .stream()
                .filter(x -> x.getUser().getId() != userId)
                .filter(x->x.getGender() == preference.getGender())
                .filter(x->x.getCity().getCountry() == preference.getCountry())
                .sorted(Comparator.comparing(x-> compareCities(x.getCity(), city)))
                .collect(Collectors.toList());
        //TODO exclude mutual likes from list
    }

    public boolean likeUser(int likeProviderUserId, ProfileDto profileDto) {
        var providerUser = userService.findById(likeProviderUserId);
        var receiverUser = userMapper.toEntity(profileDto.userDto());
        var likeProviders = receiverUser.getLikeProviders();
        likeProviders.add(providerUser);
        return providerUser.getLikeProviders().contains(receiverUser);
    }

    private int compareCities(City city, City city1) {
        return city.getName().equals(city1.getName()) ? 0 : 1;
    }
}
