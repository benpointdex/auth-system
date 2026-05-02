import React, { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import useAuth from '@/auth/store';
import { refreshToken } from '@/services/AuthService';
import { toast } from 'react-hot-toast';

const OAuth2RedirectHandler: React.FC = () => {
    const navigate = useNavigate();
    const changeLocalLoginData = useAuth(state => state.changeLocalLoginData);

    useEffect(() => {
        async function getAccessToken() {
            try {
                // Backend adds a httpOnly refresh cookie, so we can just call /refresh
                const responseLoginData = await refreshToken();
                
                // Update state
                changeLocalLoginData(
                    responseLoginData.accessToken,
                    responseLoginData.user,
                    true
                );

                toast.success("Login success!");
                navigate("/dashboard");
            } catch (error) {
                console.error("Auth redirect error", error);
                toast.error("Authentication failed");
                navigate("/login");
            }
        }

        getAccessToken();
    }, [navigate, changeLocalLoginData]);

    return (
        <div className="flex h-screen w-full items-center justify-center">
            <div className="animate-spin rounded-full h-12 w-12 border-b-2 border-blue-600"></div>
        </div>
    );
};

export default OAuth2RedirectHandler;
