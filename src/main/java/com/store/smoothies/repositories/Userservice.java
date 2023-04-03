package com.store.smoothies.repositories;


import com.store.smoothies.models.User;
import com.store.smoothies.models.UserData;

public interface UserService {

    void register(final UserData user) throws UserAlreadyExistException;
    boolean checkIfUserExist(final String email);
    void sendRegistrationConfirmationEmail(final UserEntity user);
    boolean verifyUser(final String token) throws InvalidTokenException;
    UserEntity getUserById(final String id) throws UnkownIdentifierException;
    MfaTokenData mfaSetup(final String email) throws UnkownIdentifierException, QrGenerationException;
}
