package com.example.datingApp.services;

import com.example.datingApp.dtos.ProfileDto;
import com.example.datingApp.exceptions.ProfilesNotFoundException;
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

    private final CrudService<Profile> profileService;
    private final CrudService<User> userService;
    private final UserMapper userMapper;
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

    public boolean likeUser(int likeProviderUserId, ProfileDto profileDto) {
        var providerUser = userMapper.toDto(userService.findById(likeProviderUserId));
        var receiverUser = profileDto.userDto();
        var likeProviders = receiverUser.likeProviders();
        likeProviders.add(providerUser);
        return providerUser.likeProviders().contains(receiverUser);
    }

    private int compareCities(City city, City city1) {
        return city.getName().equals(city1.getName()) ? 0 : 1;
    }
}
