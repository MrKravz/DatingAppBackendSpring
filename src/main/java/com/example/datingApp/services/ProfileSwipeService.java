package com.example.datingApp.services;

import com.example.datingApp.exceptions.ProfilesNotFoundException;
import com.example.datingApp.models.City;
import com.example.datingApp.models.Profile;
import com.example.datingApp.services.crud.ProfileService;
import com.example.datingApp.services.crud.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProfileSwipeService {

    private final ProfileService profileService;
    private final UserService userService;
    private List<Profile> swipeList;

    public List<Profile> getSwipeList(int userId) {
        var userProfile = userService.findById(userId).getProfile();
        var preference = userProfile.getUser().getPreference();
        var city = userProfile.getCity();
        var country = city.getCountry();
        var configuredSwipeList = profileService.findAll()
                .stream()
                .filter(x -> x.getUser().getId() != userId)
                .filter(x->x.getGender() != userProfile.getGender())
                .filter(x->x.getCountry() == country)
                .filter(x -> x.getUser().getAge() >= preference.getMinAge()
                        && x.getUser().getAge() <= preference.getMaxAge())
                .sorted(Comparator.comparing(x-> compareCities(x.getCity(), city)))
                .collect(Collectors.toList());
        if (configuredSwipeList == swipeList)
        {
            throw new ProfilesNotFoundException();
        }
        swipeList = configuredSwipeList;
        return swipeList;
    }

    public boolean likeUser(int likeProviderUserId, int likeReceiverUserId) {
        var providerUser = userService.findById(likeProviderUserId);
        var receiverUser = userService.findById(likeReceiverUserId);
        var likeProviders = receiverUser.getLikeProviders();
        likeProviders.add(providerUser);
        return providerUser.getLikeProviders()
                .stream()
                .anyMatch(x->x.getId() == receiverUser.getId());
    }

    private int compareCities(City city, City city1) {
        return city.getName().equals(city1.getName()) ? 0 : 1;
    }
}
